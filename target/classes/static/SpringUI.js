function body_onload() {

    var gSmsJson;

    new Vue({
        el: "#vue3",
        data: {
            showSMS: false,
            showEmail: false,
            toPhone: "",
            smsMessage: "",
            recipientEmail: "",
            senderEmail: "",
            emailPassword: "",
            emailSubject: "",
            emailMessage: "",
        },
        methods: {
            btnSmsCancel_onclick: function () {
                this.showSMS = false;
            },
            btnEmailCancel_onclick: function () {
                this.showEmail = false;
            },
            btnChooseSMS_onclick: function () {
                this.showSMS = true;
            },
            btnChooseEmail_onclick: function () {
                this.showEmail = true;
            },
            btnSmsSend_onclick: function () {
                // Pass phone number and message
                var obj = new Object();
                obj.number = toPhone;
                obj.message = smsMessage;
                gSmsJson = JSON.stringify(obj);
                var link = 'http://10.1.5.82:8080/sms?number=' + toPhone + '&message=' + textMessage;
                var final = encodeURI(link);

                $.ajax({
                    url: 'http://10.1.5.82:8080/sms',
                    type: "GET",
                    data: gSmsJson,
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (data, res) {
                        var mess = data.message.toUpperCase();
                        alert("Text Success");
                    }
                })

                // Clear message input
                this.smsMessage = "";
            },
            btnEmailSend_onclick: function () {
                // Clear subject and message input
                this.emailSubject = "";
                this.emailMessage = "";
            },
        },
    })
}