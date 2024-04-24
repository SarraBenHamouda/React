import React, { useState } from 'react';
import Form from './Form';

const Display = () => {
    const [boxes, setBoxes] = useState([]);
  
    const addBox = (color) => {
      setBoxes([...boxes, color]);
    };
  
    return (
      <div>
        <Form Box={addBox} />
        <div style={{ display: 'flex', flexWrap: 'wrap' }}>
          {boxes.map((color, i) => (
            <div
              key={i}
              style={{
                backgroundColor: color,
                width: '100px',
                height: '100px',
                margin: '10px',
              }}
            />
          ))}
        </div>
      </div>
    );
};

export default Display;
