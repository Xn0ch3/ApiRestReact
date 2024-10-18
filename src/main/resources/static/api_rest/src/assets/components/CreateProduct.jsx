import axios from "axios";
import { useState } from "react"
import Swal from "sweetalert2";
import Header from "./Header";

const CreateProduct = () => {

    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState("");
    const [stock, setStock] = useState("");

    const urlCreate = "http://localhost:8080/product/create"

    const productCreate = async (name, description, price, stock) => {

        const token = localStorage.getItem("token");

        if (!token) {
            console.error("Token no encontrado");
            setError("Token no encontrado. Por favor, inicia sesión.");
            setLoading(false);
            return;
        }

        try {

            const config = {
                headers: {
                    Authorization: `Bearer ${token}`, // Enviar el token en el header de la solicitud
                },
            };

            const response = await axios.post(urlCreate, { name, description, price, stock }, config);
            console.log(response.data)


            Swal.fire({
                icon: 'success',
                title: '¡Éxito!',
                text: 'Producto creado correctamente.',
                confirmButtonText: 'Aceptar'
            });

        } catch {

            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: error.response?.data?.message || 'Ocurrió un problema al crear un nuevo producto',
                confirmButtonText: 'Aceptar'
            });
        }

    }


    const handleSubmitProduct = (event) => {
        event.preventDefault();
        // Llamar a la función login al enviar el formulario
        productCreate(name, description, price, stock);
    };

    return (

        <div>

            <Header></Header>

            <form onSubmit={handleSubmitProduct} className="mt-10 max-w-md mx-auto bg-white p-8 shadow-md rounded-lg">
                <h2 className="text-2xl font-bold mb-6 text-gray-800">Crear Producto</h2>

                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Nombre del Producto</label>
                    <input
                        value={name}
                        type="text"
                        className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                        placeholder="Nombre del producto"
                        onChange={(e) => setName(e.target.value)}
                        required
                    />
                </div>

                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Descripción</label>
                    <textarea
                        value={description}
                        className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                        placeholder="Descripción del producto"
                        onChange={(e) => setDescription(e.target.value)}
                        required
                    />
                </div>

                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Precio</label>
                    <input
                        value={price}
                        type="number"
                        step="0.01"
                        className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                        placeholder="Precio del producto"
                        onChange={(e) => setPrice(e.target.value)}
                        required
                    />
                </div>

                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Stock</label>
                    <input
                        value={stock}
                        type="number"
                        className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                        placeholder="Cantidad disponible"
                        onChange={(e) => setStock(e.target.value)}
                        required
                    />
                </div>

                <div>
                    <button
                        type="submit"
                        className="w-full bg-indigo-500 text-white font-bold py-3 px-4 rounded-lg hover:bg-indigo-600 focus:outline-none focus:ring-4 focus:ring-indigo-300 transition duration-300"
                    >
                        Crear Producto
                    </button>
                </div>
            </form>

        </div>
    )
}
export default CreateProduct