import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Search from './pages/Search';
import Header from './pages/Header';
import Footer from './pages/Footer';

function App() {
    return (
        <Router>
            <div className="d-flex flex-column min-vh-100">
                <Header/>
                <main className="flex-grow-1">
                    <Routes>
                        <Route path="/" element={<Search/>}/>
                    </Routes>
                </main>
                <Footer />
            </div>
        </Router>
);
}

export default App;
