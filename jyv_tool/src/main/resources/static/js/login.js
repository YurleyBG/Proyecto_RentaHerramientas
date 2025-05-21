
const userNew= document.getElementById("login");
userNew.addEventListener('submit', async (event) =>{
    
    event.preventDefault();
    const username =document.getElementById("usuario").value;
    const password =document.getElementById("contraseña").value;

    try {   
        const newUsuario = await fetch('/auth/login',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json' 
            },
            body: JSON.stringify({
                username: username,
                password: password,
               
            })
        });
        if(newUsuario.ok){
            const daticos = await newUsuario.json();

            if(daticos.token){
                console.log(daticos.token)
                localStorage.setItem('jwtToken',daticos.token)
                console.log("guardado");
                alert('Se inicio sesion');
                window.location.href = '/PaginaPrincipal';

            }
        }
    }
    catch(error){
        alert('No se pudo iniciar sesion');

    }
});
