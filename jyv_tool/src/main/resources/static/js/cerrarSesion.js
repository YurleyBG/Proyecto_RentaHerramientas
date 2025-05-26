const cerrar=document.getElementById("cerrar");
if(cerrar){

    cerrar.addEventListener('click', async (event) =>{

        event.preventDefault();
        if(confirm("Desea finalizar la sesion?")){
            localStorage.removeItem('jwt_token');
            window.location.href = '/loginVista';
        }
    });
}
else{
    alert("Fallo el cierre de sesion");
}
