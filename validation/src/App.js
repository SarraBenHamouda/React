import React, { useState } from 'react';
import './App.css';
import Display from './components/display.jsx';
import Form from './components/Form.jsx';

function App() {
  const [Box, setBox] = useState([
    { color: "red" },
    { color: "blue" },
    { color: "green" }
  ]);
  
  const addBox = (color) => {
    setBox([...Box, { color }]);
  };

  return (
    <div className="App">
      <fieldset>
        <legend>App.js</legend>
      
        {JSON.stringify(Box)}
        <Display Box={Box} />
        <Form Box={addBox} />
      </fieldset>
    </div>
  );
}

export default App;
