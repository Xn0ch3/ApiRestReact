import { useState } from 'react'
import Home from './assets/components/Home'
import { Routes, Route } from 'react-router-dom'
import Products from './assets/components/Products'
import CreateProduct from './assets/components/CreateProduct'

function App() {
  const [count, setCount] = useState(0)

  return (
    <Routes>
      <Route path='/' element={<Home />} />
      <Route path='/product' element={<Products/>} />
      <Route path="/create" element={<CreateProduct />} />
    </Routes>
  )
}

export default App
