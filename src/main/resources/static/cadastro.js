const form = document.getElementById("cadastroForm");
const mensagem = document.getElementById("mensagem");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const role = document.getElementById("role").value;

    if (password.length < 4) {
        mensagem.innerText = "Senha deve ter no mínimo 4 caracteres";
        mensagem.style.color = "red";
        return;
    }

    try {

        const response = await fetch("http://localhost:8080/auth/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username,
                password,
                role
            })
        });

        if (response.ok) {
            mensagem.innerText = "Usuário cadastrado com sucesso!";
            mensagem.style.color = "green";
            form.reset();
        } else {
            mensagem.innerText = "Erro ao cadastrar usuário";
            mensagem.style.color = "red";
        }

    } catch (error) {
        mensagem.innerText = "Erro na conexão com servidor";
        mensagem.style.color = "red";
        console.error(error);
    }
});
