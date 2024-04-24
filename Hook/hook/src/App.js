import React, { useState } from 'react';

const Form = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  return (
    <fieldset>
      <legend>
        Form.jsx
      </legend>
      <p>FirstName</p>
      {JSON.stringify(firstName)}
      <br></br><p>LastName</p>
      {JSON.stringify(lastName)}
      <br></br><p>Email</p>
      {JSON.stringify(email)}
      <br></br><p>Password</p>
      {JSON.stringify(password)}
      <br></br><p>ConfirmPassword</p>
      {JSON.stringify(confirmPassword)}
      <br></br>
      <form>
      <p>
        Enter First Name: <input onChange={(e) => { setFirstName(e.target.value) }} />
      </p>
      <p>
        Enter Last Name: <input onChange={(e) => { setLastName(e.target.value) }} />
      </p>
      <p>
        Enter Email: <input  onChange={(e) => { setEmail(e.target.value) }} />
      </p>
      <p>
        Enter Password: <input  onChange={(e) => { setPassword(e.target.value) }} />
      </p>
      <p>
        Confirm Password: <input  onChange={(e) => { setConfirmPassword(e.target.value) }} />
      </p>
      </form>
    </fieldset>
  );
}

export default Form;
