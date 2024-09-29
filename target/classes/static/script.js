function showMovies() {
    fetch('/api/movies')
        .then(response => response.json())
        .then(movies => {
            const mainContent = document.getElementById('main-content');
            mainContent.innerHTML = '<h2>Available Movies</h2>';
            const movieList = document.createElement('div');
            movieList.className = 'movie-list';
            movies.forEach(movie => {
                const movieCard = document.createElement('div');
                movieCard.className = 'movie-card';
                movieCard.innerHTML = `
                    <h3>${movie.title}</h3>
                    <p>${movie.genre}</p>
                    <button onclick="showMovieDetails(${movie.id})">View Details</button>
                `;
                movieList.appendChild(movieCard);
            });
            mainContent.appendChild(movieList);
        })
        .catch(error => console.error('Error:', error));
}

function showMovieDetails(movieId) {
    fetch(`/api/movies/${movieId}`)
        .then(response => response.json())
        .then(movie => {
            const mainContent = document.getElementById('main-content');
            mainContent.innerHTML = `
                <h2>${movie.title}</h2>
                <p>Genre: ${movie.genre}</p>
                <p>Duration: ${movie.duration} minutes</p>
                <h3>Screenings:</h3>
                <ul id="screening-list"></ul>
            `;
            const screeningList = document.getElementById('screening-list');
            movie.screenings.forEach(screening => {
                const li = document.createElement('li');
                li.innerHTML = `
                    ${screening.startTime}
                    <button onclick="bookTicket(${screening.id})">Book</button>
                `;
                screeningList.appendChild(li);
            });
        })
        .catch(error => console.error('Error:', error));
}

function bookTicket(screeningId) {
    // In a real application, you'd open a form to collect user details
    // and then send a POST request to book the ticket
    alert(`Booking ticket for screening ${screeningId}`);
}
function addMovie(event) {
    event.preventDefault();
    const movie = {
        title: document.getElementById('movieTitle').value,
        genre: document.getElementById('movieGenre').value,
        duration: document.getElementById('movieDuration').value
    };

    fetch('/api/movies', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(movie),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        showMovies();  // Refresh the movie list
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

function showBookings() {
    // In a real application, you'd fetch the user's bookings from the server
    const mainContent = document.getElementById('main-content');
    mainContent.innerHTML = '<h2>My Bookings</h2><p>No bookings found.</p>';
}
function addMovie(event) {
    event.preventDefault();
    const movie = {
        title: document.getElementById('movieTitle').value,
        genre: document.getElementById('movieGenre').value,
        duration: document.getElementById('movieDuration').value
    };

    fetch('/api/movies', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(movie),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        showMovies();  // Refresh the movie list
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

// Load movies when the page loads
window.onload = showMovies;