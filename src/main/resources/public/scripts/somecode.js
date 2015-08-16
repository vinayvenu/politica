var Member = React.createClass({
    render: function () {
        return (
            <div className="member">
                <div><h1>Closest member of {this.props.member.type}</h1></div>
                <div><b>Name:</b> {this.props.member.memberData.first_name} {this.props.member.memberData.last_name}
                </div>
                <div><b>Constituency:</b> {this.props.member.memberData.constituency}</div>
                <div><b>Attendance Percentage:</b> {this.props.member.memberData.attendance_percentage}%</div>
                <div><b>Political Party Alignment:</b> {this.props.member.memberData.party}</div>
                <div><b>Email Address:</b> {this.props.member.memberData.email_address}</div>
                <div><b>Phone Number:</b> {this.props.member.memberData.phone_number}</div>
            </div>
        )
    }
});
var VicinityMembers = React.createClass({
    getMembers: function (latitude, longitude) {
        $.ajax({
            type: 'GET',
            url: this.props.url,
            data: {x: longitude, y: latitude},
            dataType: 'json',
            success: function (data) {
                var mop = {
                    type: "Parliament",
                    memberData: data.memberOfParliament
                };
                var mla = {
                    type: "Legislative Assembly",
                    memberData: data.memberOfLegislativeAssembly
                };
                var mlc = {
                    type: "Legislative Council",
                    memberData: data.memberofLegislativeCouncil
                };
                this.setState({members: [mop, mla, mlc]});
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    },
    getInitialState: function () {
        return {members: [], latitude: 0, longitude: 0};
    },
    setPosition: function (position) {
        this.setState({latitude: position.coords.latitude, longitude: position.coords.longitude});
        this.getMembers(this.state.latitude, this.state.longitude);
    },
    getLocation: function () {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(this.setPosition);
        }
    },
    componentDidMount: function () {
        this.getLocation();
    },
    render: function () {
        var renderMembers = this.state.members.map(function (member) {
            return member.memberData != null ? (<Member member={member}/>) : (<div>
                <h1>Closest Member of {member.type} not found</h1>
            </div>);
        });
        return (
            <div className="members">
                {renderMembers}
            </div>
        );
    }
});

React.render(
    <VicinityMembers url="/leaders"/>,
    document.getElementById('content')
);
