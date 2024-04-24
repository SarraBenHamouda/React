import React, { useState } from 'react';

const Form = ({ Box }) => {
  const [color, setColor] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (color.trim() !== "") {
      Box(color); // Call the addBox function passed from the parent component
      setColor("");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="colorInput">Enter Color:</label>
      <input
        type="text"
        id="colorInput"
        value={color}
        onChange={(e) => setColor(e.target.value)}
      />
      <button type="submit">Add Box</button>
    </form>
  );
};

export default Form;
