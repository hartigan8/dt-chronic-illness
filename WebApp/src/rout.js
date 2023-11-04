import React from 'react'
import { Routes, Route } from 'react-router-dom'
import Signup from './signup'

const Rout = () => {
  return (

      <Routes>
        <Route path="/" element={<Signup />}></Route> 
      </Routes>  
      
         )
}

export default Rout