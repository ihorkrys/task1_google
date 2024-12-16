import React, { useState } from 'react';
import {
    errorHandling,
    performSearch
} from '../services/api';

function Search() {
    const [query, setQuery] = useState("");
    const [results, setResults] = useState([]);

    const handleSearch = () => {
        performSearch(query)
            .then((response) => {
                console.log(response);
                setResults(response.data.entries);
            })
            .catch(errorHandling);
        ;
    };

    return (
        <div style={{ margin: "20px", fontFamily: "Arial, sans-serif" }}>
            <h1>Search Page</h1>
            <div style={{ marginBottom: "20px" }}>
                <input
                    type="text"
                    placeholder="Enter search text"
                    value={query}
                    onChange={(e) => setQuery(e.target.value)}
                    style={{ padding: "10px", width: "300px", marginRight: "10px" }}
                />
                <button
                    onClick={handleSearch}
                    style={{
                        padding: "10px 20px",
                        backgroundColor: "#007BFF",
                        color: "white",
                        border: "none",
                        cursor: "pointer",
                    }}
                >
                    Search
                </button>
            </div>
            {results.length > 0 ? (
                <div>
                    <h2>Search Results:</h2>
                    <ul style={{ listStyleType: "none", padding: 0 }}>
                        {results.map((entry, index) => (
                            <li
                                key={index}
                                style={{
                                    marginBottom: "10px",
                                    padding: "10px",
                                    border: "1px solid #ddd",
                                    borderRadius: "5px",
                                }}
                            >
                                <strong>{entry.title}</strong>
                                <p>{entry.shortBody}</p>
                            </li>
                        ))}
                    </ul>
                </div>
            ) : (
                <p>No results found.</p>
            )}
        </div>
    );
}

export default Search;