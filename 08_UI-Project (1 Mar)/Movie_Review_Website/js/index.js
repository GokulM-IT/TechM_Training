const moviesContainer = document.querySelector('#movies-container');
const animesContainer = document.querySelector('#animes-container');

const displayCard = (container, item) => {
    const div = document.createElement('div');
    const randomRating = Math.floor(Math.random() * 5) + 5;

    div.innerHTML = `
    <img src="${item.Poster}" alt="${item.Title}">
    <p class="title" style="word-wrap: break-word;">${item.Title}</p>
    <p class="rating">${`⭐ ${randomRating}`}</p>
    <p class="year">${item.Year}</p>
    `;
    container.append(div);
};

const fetchData = async () => {
    try {
        const response = await fetch('../utils/data.json');
        const data = await response.json();

        data.movies.forEach(movie => {
            displayCard(moviesContainer, movie);
        });

        data.animes.forEach(anime => {
            displayCard(animesContainer, anime);
        });
    } catch (error) {
        console.error('Error fetching data:', error);
    }
};

fetchData();