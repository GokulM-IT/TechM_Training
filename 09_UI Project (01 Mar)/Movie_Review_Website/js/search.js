const container = document.querySelector('#container');
const form = document.querySelector('form');

const displayCard = (data) => {
    data.forEach(movie => {
        if (movie.Poster !== 'N/A') {
            const div = document.createElement('div');
            const randomRating = Math.floor(Math.random() * 5) + 5;

            div.innerHTML = `
            <img src="${movie.Poster}" alt="${movie.Title}">
            <p class="title" style="word-wrap: break-word;">${movie.Title}</p>
            <p class="rating">${`⭐ ${randomRating}`}</p>
            <p class="year">${movie.Year}</p>
            `
            container.append(div);
        }
    });
}

const setShowImage = (data) => {
    container.innerHTML = '';
    container.classList.remove('no-results-container');

    if (data === undefined) {
        const div = document.createElement('div');
        container.classList.add('no-results-container');
        div.classList.add('no-results');
        div.innerHTML = `<p>No results found</p>`
        container.append(div);
    } else {
        displayCard(data)
    }
}

form.addEventListener('submit', async (event) => {
    event.preventDefault();
    const query = form.query.value;
    const config = { params: { s: query } }

    try {
        const response = await axios.get("https://www.omdbapi.com/?i=tt3896198&apikey=df6d6f0e", config)
        setShowImage(response.data.Search)
    } catch (error) {
        console.log('Error fetching data : ', error)
    }

    form.query.value = '';
})
