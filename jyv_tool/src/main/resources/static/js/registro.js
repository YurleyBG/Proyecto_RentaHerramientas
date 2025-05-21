
const userNew= document.getElementById("regitrarUser");
userNew.addEventListener('submit', async (event) =>{
    
    event.preventDefault();
    const nombre =document.getElementById("nombre").value;
    const apellido =document.getElementById("apellido").value;
    const email =document.getElementById("email").value;
    const contraseña =document.getElementById("password").value;
    const rol =document.getElementById("rol").value;
    console.log(rol);
    try {   
        const newUsuario = await fetch('/auth/registrar',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json' 
            },
            body: JSON.stringify({
                username: nombre,
                password: contraseña,
                nombre: nombre,
                apellido: apellido,
                rol: rol,
                email: email
                
            })
        });
        if(newUsuario.ok){
            const daticos = await newUsuario.json();

            if(daticos.token){

                localStorage.setItem('jwtToken',daticos.token)
                console.log("guardado");
                alert('¡Registro exitoso! Ahora puedes iniciar sesión.');
                window.location.href = '/login';

            }
        }
    }
    catch(error){
        alert('No se completo el registro');

    }
});
