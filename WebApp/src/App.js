import React from 'react'
import {BrowserRouter} from 'react-router-dom'
import Rout from './rout'
import Signup from './signup'
const App = () => {
  return (
    

    <BrowserRouter>
      <Rout />
      <Signup />
    </BrowserRouter> 
  )
}

export default App