import React from "react";
import * as Components from './Components';
import { useNavigate } from "react-router-dom";
function Forms() {
    const isValidEmail = (email) => /\S+@\S+\.\S+/.test(email);
    const isValidPassword = (password) => password.length >= 6;
    const [login, toggle] = React.useState(true);
    const [loginMail, setLoginMail] = React.useState('');
    const [loginPassword, setLoginPassword] = React.useState('');
    const [registerMail, setRegisterMail] = React.useState('');
    const [registerPassword, setRegisterPassword] = React.useState('');
    const [registerName, setRegisterName] = React.useState('');
    let navigate = useNavigate();
    const handleRegisterName = (value) =>{
        setRegisterName(value)
    }
    const handleLoginEmail = (value) =>{
        setLoginMail(value)
    }
    const handleLoginPassword = (value) =>{
        setLoginPassword(value)
    }
    const handleRegisterEmail = (value) =>{
        setRegisterMail(value)
    }
    const handleRegisterPassword = (value) =>{
        setRegisterPassword(value)
    }
    const handleRegisterSubmit = async (event) => {
        event.preventDefault(); // Prevent the form from submitting naturally
        /*
        if (!isValidEmail(registerMail) || !isValidPassword(registerPassword)) {
            console.error('Invalid email or password');
            return;
        }
        */
        try {
            const response = await fetch('http://localhost:8080/auth/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    name: registerName,
                    email: registerMail,
                    password: registerPassword,
                }),
            });
    
            const data = await response.json();
            if (response.ok) {
                // Save the tokens. You might want to save them in localStorage or in a state management library
                localStorage.setItem('access_token', data.access_token);
                localStorage.setItem('refresh_token', data.refresh_token);
                navigate('/success');
                // Redirect the user or perform other actions like updating the UI
            } else {
                // Handle errors - data might include error message
                console.error(data.message);
            }
        } catch (error) {
            console.error('Error during registration:', error);
        }
    };
    
    const handleLoginSubmit = async (event) => {
        event.preventDefault(); // Prevent the form from submitting naturally
        /*
        if (!isValidEmail(registerMail) || !isValidPassword(registerPassword)) {
            console.error('Invalid email or password');
            return;
        }
        */
        try {
            const response = await fetch('http://localhost:8080/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    email: loginMail,
                    password: loginPassword,
                }),
            });
            
            const data = await response.json();
            if (response.ok) {
                // Save the tokens. You might want to save them in localStorage or in a state management library
                localStorage.setItem('access_token', data.access_token);
                localStorage.setItem('refresh_token', data.refresh_token);
                // Redirect the user or perform other actions like updating the UI
                navigate('/success');
            } else {
                // Handle errors - data might include error message
                console.error(data.message);
            }
        } catch (error) {
            console.error('Error during login:', error);
        }
    };

    return (
    <Components.Container>
        <Components.SignUpContainer signinIn={login}>
            <Components.Form onSubmit={handleRegisterSubmit}>
                <Components.Title>Create Account</Components.Title>
                <Components.Input type='text' placeholder='Name' onChange={(e) => handleRegisterName(e.target.value)} />
                <Components.Input type='email' placeholder='Email' onChange={(e) => handleRegisterEmail(e.target.value)} />
                <Components.Input type='password' placeholder='Password' onChange={(e) => handleRegisterPassword(e.target.value)} />
                <Components.Button type="submit">Sign Up</Components.Button>
            </Components.Form>
        </Components.SignUpContainer>

        <Components.SignInContainer signinIn={login}>
            <Components.Form onSubmit={handleLoginSubmit}>
                <Components.Title>Sign in</Components.Title>
                <Components.Input type='email' placeholder='Email' onChange={(e) => handleLoginEmail(e.target.value)} />
                <Components.Input type='password' placeholder='Password' onChange={(e) => handleLoginPassword(e.target.value)} />
                <Components.Anchor href='#'>Forgot your password?</Components.Anchor>
                <Components.Button type="submit">Sign In</Components.Button>
            </Components.Form>
        </Components.SignInContainer>

        <Components.OverlayContainer signinIn={login}>
                  <Components.Overlay signinIn={login}>

                  <Components.LeftOverlayPanel signinIn={login}>
                      <Components.Title>Welcome Back!</Components.Title>
                      <Components.Paragraph>
                          To keep connected with us please login with your personal info
                      </Components.Paragraph>
                      <Components.GhostButton onClick={() => toggle(true)}>
                          Sign In
                      </Components.GhostButton>
                      </Components.LeftOverlayPanel>

                      <Components.RightOverlayPanel signinIn={login}>
                        <Components.Title>Hello, Friend!</Components.Title>
                        <Components.Paragraph>
                            Enter Your personal details and start journey with us
                        </Components.Paragraph>
                            <Components.GhostButton onClick={() => toggle(false)}>
                                Sigin Up
                            </Components.GhostButton> 
                      </Components.RightOverlayPanel>
  
                  </Components.Overlay>
              </Components.OverlayContainer>
    </Components.Container>
);
}
export default Forms;