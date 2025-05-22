const url="http://localhost:8080/Api/herramienta"

fetch(url)
.then(response =>response.json())
.then(data=>{
    console.log(data)
    const contenedor = document.getElementById('cajitaPrinci');
    data.forEach(element => {
    
        const seccion = document.createElement('div');
        seccion.className = 'seccion1';

        const caja = document.createElement('div');
        caja.className = 'herramientascaja';

        
        const imgContainer = document.createElement('div');
        imgContainer.className = 'cajaimg';
        imgContainer.style.backgroundImage = `url(${element.urlImage})`;
        imgContainer.style.backgroundSize = 'contain';
        imgContainer.style.backgroundRepeat = 'no-repeat';


        const TextoContainer = document.createElement('div');
        TextoContainer.className = 'cajaTexto';
        TextoContainer.innerHTML = `<strong>${element.nombre}</strong>
        <br>${element.detalle?.marca} <br>${element.detalle?.precio_Diario}`;

        
        caja.appendChild(imgContainer);
        caja.appendChild(TextoContainer);
        seccion.appendChild(caja);
        contenedor.appendChild(seccion);
        
    });

})