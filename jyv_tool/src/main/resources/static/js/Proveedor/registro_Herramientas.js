// /src/main/resources/static/js/proveedores/registro_Herramientas.js

function botonFuncion(){
    const NewHerramienta= {
        "nombre": document.querySelector(".Nombre").value,
        "UrlImage": document.querySelector(".URL_Img").value,
        "categoriaId": document.getElementById("categoriaHerramienta").value, // O el ID que hayas definido para tu select
        "Marca": document.querySelector(".Marca").value,
        "Modelo": document.querySelector(".Modelo").value,
        "Precio_Diario": parseFloat(document.querySelector(".Precio").value),
        "Descripcion": document.querySelector(".Descripcion").value
    }

    fetch("http://localhost:8080/Api/Herramienta",{
        method: "POST",
        headers: {
            'Authorization': `Bearer ${localStorage.getItem("token")}`,
            'Content-Type': `application/json; charset=UTF-8`
        },
        body: JSON.stringify(NewHerramienta)
    })
    .then(response => {
        if(response.ok){
            alert("Herramienta Agregada exitosamente!")
            // Opcional: limpiar los campos del formulario
            document.querySelector(".Nombre").value = "";
            document.querySelector(".URL_Img").value = "";
            document.getElementById("categoriaHerramienta").value = "";
            document.querySelector(".Marca").value = "";
            document.querySelector(".Modelo").value = "";
            document.querySelector(".Precio").value = "";
            document.querySelector(".Descripcion").value = "";
        } else {
            response.json().then(errorData => {
                alert("Error al agregar herramienta: " + (errorData.message || "Error desconocido."));
            }).catch(() => {
                alert("Error al agregar herramienta. Código de estado: " + response.status);
            });
        }
    })
    .catch(error=>{
        console.error('Error de red o en la solicitud:', error);
        alert("No se pudo conectar con el servidor. Por favor, verifica tu conexión.");
    })
}