-- Load data
data = LOAD '/bda1/input_word_count.txt' AS (line:CHARARRAY);

-- Tokenize words
words = FOREACH data GENERATE FLATTEN(TOKENIZE(line)) AS word;

-- Group by word and count occurrences
word_count = GROUP words BY word;
word_count_result = FOREACH word_count GENERATE group AS word, COUNT(words) AS count;

-- Store result
STORE word_count_result INTO '/bda1/word_count_out';
