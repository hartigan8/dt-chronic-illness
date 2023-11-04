import React from 'react'
import './signup.css'
import { Link } from 'react-router-dom'
import firebase from './firebase'

const Signup = () => {
    const [username, setUsername] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] =useState('')
    const submit = async(e) => {
        e.preventDefault()
        try{
            const user = await firebase.auth().createUserWithEmailAndPassword(email, password)
            if(user)
            {
                alert('User Created')
            }
        }
        catch(error)
        {
            alert(error)
        }
    }    
  return (

    <div className='main_container_signup'>
        <div class="header">
            <h2>Sign Up</h2>
        </div>
        <div class="box">
            <input type="text" value={username} placeholder="Username" onChange={(e)=> setUsername(e.target.value)} ></input>
        </div>
        <div class="box">
            <input type="text" value={email} placeholder="E-Mail" onChange={(e)=> setEmail(e.target.value)}></input>
        </div>
        <div class="box">
            <input type="text" value={password} placeholder="Passaword" onChange={(e)=> setPassword(e.target.value)}></input>
        </div>
        <p>Already have an account? <Link to='/login'>Login Now</Link></p>
        <button onClick={submit}>Sign Up</button>



    </div>      
    )
}

export default Signup