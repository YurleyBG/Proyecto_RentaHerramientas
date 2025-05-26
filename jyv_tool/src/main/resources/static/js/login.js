
document.addEventListener('DOMContentLoaded', () => {

    const loginButton = document.getElementById('Iniciar');
 
    if (loginButton) {
      
       
        loginButton.addEventListener('click', async () => {

         
            const username = document.getElementById("usuario").value;
            const password = document.getElementById("contraseña").value;

            try {
                console.log("holaaa")
                const loginResponse = await fetch('/auth/login', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ username, password })
                });
                console.log("entro");
                console.log(username)
                console.log(password)
                console.log(loginResponse)

                if (!loginResponse.ok) {
                    alert('Credenciales incorrectas');
                    return; 
                }


                const loginData =  await loginResponse.json();
               
                


                if (loginData.token && typeof loginData.token === 'string' && loginData.token.length > 10) {
                    console.log(loginData.username)
                    console.log(loginData.token)
                    document.cookie = `jwtToken=${loginData.token}; path=/; SameSite=Strict; max-age=${3600 * 24}`;

                    alert('Sesión iniciada correctamente');
                    window.location.href = '/PaginaPrincipal';

                } else {
                    alert('No se recibió un token válido del servidor');
                }

            } catch (error) {
                console.error('Error al iniciar sesión:', error);
                alert('Hubo un problema al intentar conectar con el servidor.');
            }
        });
    } else {
        console.error("Botón de login no encontrado. Asegúrate de que el ID 'btnIniciarSesion' sea correcto.");
    }
});