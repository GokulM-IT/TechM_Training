const reviewsContainer = document.querySelector('#reviews-container');

const displayReview = (review) => {
    const div = document.createElement('div');
    div.classList.add('review-card');

    div.innerHTML = `
    <div class="review-content">
        <div class="movie-details">
            <img src="${review.Poster}" alt="${review.Title}" class="review-poster">
            <div class="review-details">
                <p class="title">${review.Title}</p>
                <p class="rating">${`⭐ ${review.Rating}`}</p>
                <p class="review-text">${review.Review}</p>
            </div>
        </div>
        <h3>Reviews</h3>
        <div class="user-reviews">
            ${review.userReview.map(userReview => `
                <div class="user-review">
                    <p class="user-name">${userReview.username}</p>
                    <p class="user-comment">${userReview.comment}</p>
                </div>
            `).join('')}
        </div>
    </div>
    `;
    reviewsContainer.append(div);
};

const fetchReviews = async () => {
    try {
        const response = await fetch('../utils/data.json');
        const data = await response.json();

        data.reviews.forEach(review => {
            displayReview(review);
        });
    } catch (error) {
        console.error('Error fetching reviews:', error);
    }
};

fetchReviews();
