class home {

    sendButton;
    logoutButton;

    sendForm;

    constructor() {

        this.sendForm = document.getElementById("send-form");

        this.logoutButton = document.getElementById("logout-button");
        this.sendButton = document.getElementById("send-button");

        this.logoutButton.addEventListener("click", this.logout);
        this.sendButton.addEventListener("click", this.submitSendForm);
    }

    submitSendForm = (event) => {
        event.preventDefault();
        this.sendForm.action = "/send";//채팅방 아이디 필요.
        this.sendForm.method = "POST";
        this.sendForm.submit();

    }

    logout = (event) => {
        event.preventDefault();
        const confirmed = confirm("로그아웃하시겠습니까?");
        if (confirmed) {
            window.location.href = "/logout";
        }
    }
}
