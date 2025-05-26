const url = "http://localhost:8080/Api/herramienta";
const buscador = document.getElementById('buscadorfiltro');
const contenedor = document.getElementById('cajitaPrinci');

async function CargarHerramientas(buscar = "") {
    contenedor.innerHTML = '<h2 class="text-center"> Cargando herramientas...</h2>';

    let finalUrl = new URL(url);

    if (buscar) {
        finalUrl.searchParams.append('search', buscar);
    }

    try {
        const response = await fetch(finalUrl.toString());

        if (!response.ok) {
            const errorData = await response.json().catch(() => ({ message: 'Error' }));
            throw new Error(`Error HTTP: ${response.status} ${response.statusText} - ${errorData.message || 'Error desconocido'}`);
        }

        const data = await response.json();
        console.log(data);

        contenedor.innerHTML = '';

        if (data.length === 0) {
            contenedor.innerHTML = '<h2 class="text-center">No se encontraron herramientas </h2>';
            return;
        }

        data.forEach(element => {
            const herraCard = document.createElement('div');
            herraCard.className = 'herramientascaja';

            const imgContainer = document.createElement('div');
            imgContainer.className = 'cajaimg';
            const imageUrl = element.urlImage || 'https://placehold.co/150x150/cccccc/333333?text=No+Image';
            imgContainer.style.backgroundImage = `url(${imageUrl})`;
            imgContainer.style.backgroundSize = 'contain';
            imgContainer.style.backgroundRepeat = 'no-repeat';
            imgContainer.style.backgroundPosition = "center";

            const TextoContainer = document.createElement('div');
            TextoContainer.className = 'cajaTexto';
            TextoContainer.innerHTML = `
                <strong>${element.nombre || 'Nombre no disponible'}</strong>
                <br>Marca: ${element.detalle?.marca || 'N/A'}
                <br>Precio: $${element.detalle?.precio_Diario ? element.detalle.precio_Diario.toFixed(2) : 'N/A'}
            `;
            const botonReserva= document.createElement("button");
            botonReserva.className='btnreserva';
            botonReserva.innerHTML = '+';

            herraCard.appendChild(imgContainer);
            TextoContainer.appendChild(botonReserva)
            herraCard.appendChild(TextoContainer);
            contenedor.appendChild(herraCard);
        });

    } catch (error) {
        console.error('Error al cargar herramientas:', error);
        contenedor.innerHTML = `<h2 class="Text_Cargar">Error al cargar herramientas: ${error.message}</h2>`;
    }
}

document.addEventListener('DOMContentLoaded', () => {
    CargarHerramientas();

    buscador.addEventListener('keypress', (event) => {
        if (event.key === 'Enter') {
            const searchTerm = buscador.value.trim();
            CargarHerramientas(searchTerm);
        }
    });
});