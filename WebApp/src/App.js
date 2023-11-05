import React from "react";
import * as Components from './Components';
import SuccessPage from './SuccessPage';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Forms from './Forms';

 function App() {
    

    return (
        <Router>
            <Routes>
                <Route path="/success" element={<SuccessPage />} />
                <Route path="/" element={<Forms />} /> {/* Use the Forms component here */}
            </Routes>
        </Router>
    );
}
    

 export default App;