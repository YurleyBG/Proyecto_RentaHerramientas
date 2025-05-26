
document.addEventListener('DOMContentLoaded', () => {

    const loginformu = document.getElementById('login');
 
    if (loginformu) {
      
       
        loginformu.addEventListener('submit', async (event) => {

            event.preventDefault();
         
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
                    console.log(loginData.role)
                    alert('Sesión iniciada correctamente');
                    if (loginData.role == 'Cliente') {
                        window.location.href = '/PaginaPrincipal';
                    } else if (loginData.role == 'Administrador') {
                        window.location.href = '/admin_devolucion'; 
                    } else if (loginData.role =='Proveedor') {
                        window.location.href = '/PrincipalProveedor'; 
                    } else {
                        window.location.href = '/Home';
                    }

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