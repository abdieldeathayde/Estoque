const form = document.getElementById("loginForm");
const mensagem = document.getElementById("mensagem");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    try {

        const response = await fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username,
                password
            })
        });

        if (!response.ok) {
            mensagem.innerText = "Usuário ou senha inválidos";
            mensagem.style.color = "red";
            return;
        }

        const data = await response.json();

        // ✅ salva JWT
        localStorage.setItem("token", data.token);

        mensagem.innerText = "Login realizado!";
        mensagem.style.color = "green";

        // redireciona
        setTimeout(() => {
            window.location.href = "dashboard.html";
        }, 1000);

    } catch (error) {
        mensagem.innerText = "Erro ao conectar com servidor";
        mensagem.style.color = "red";
        console.error(error);
    }
});
