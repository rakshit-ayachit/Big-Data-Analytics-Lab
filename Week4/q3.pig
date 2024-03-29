-- Load ratings data
ratings = LOAD 'ratings.data' USING PigStorage('\t') AS (userID:INT, movieID:INT, rating:DOUBLE, timestamp:INT);

-- Group ratings by movieID and calculate average rating
avg_ratings = GROUP ratings BY movieID;
avg_rating_result = FOREACH avg_ratings GENERATE group AS movieID, AVG(ratings.rating) AS avg_rating;

-- Load movie data
movies = LOAD 'movies.item' USING PigStorage('|') AS (movieID:INT, title:CHARARRAY, release_date:CHARARRAY, video_release_date:CHARARRAY, IMDb_URL:CHARARRAY, unknown:INT, Action:INT, Adventure:INT, Animation:INT, Childrens:INT, Comedy:INT, Crime:INT, Documentary:INT, Drama:INT, Fantasy:INT, Film_Noir:INT, Horror:INT, Musical:INT, Mystery:INT, Romance:INT, Sci_Fi:INT, Thriller:INT, War:INT, Western:INT);

-- Join average ratings with movie data
joined_data = JOIN avg_rating_result BY movieID, movies BY movieID;

-- Order by average rating in descending order
ordered_data = ORDER joined_data BY avg_rating_result::avg_rating DESC;

-- Get the most popular movie
most_popular_movie = LIMIT ordered_data 1;

-- Display the result
DUMP most_popular_movie;
