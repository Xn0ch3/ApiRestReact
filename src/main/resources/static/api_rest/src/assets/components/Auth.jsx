import { useState } from "react";
import axios from "axios";
import Swal from "sweetalert2";

const Auth = () => {

    const [isLogin, setIsLogin] = useState(true);

    const [name, setName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [errorMessage, setErrorMessage] = useState("");
    const [successMessage, setSuccessMessage] = useState("");

    const endPoint = "http://localhost:8080/auth/login";
    const registerEndpoint = "http://localhost:8080/user/register";

    const login = async (email, password) => {
        try {
            // Realiza la solicitud POST con axios
            const response = await axios.post(endPoint, { email, password });

            console.log("Login Response:", response.data);

            // Guarda el token en localStorage
            const token = response.data.jwt;
            console.log(token) // Asegúrate de que el backend te envíe el token en "token"
            if (token) {
                localStorage.setItem("token", token); // Guarda el token en localStorage
            } else {
                throw new Error("No se recibió un token de autenticación.");
            }

            Swal.fire({
                icon: 'success',
                title: '¡Éxito!',
                text: 'Has iniciado sesión correctamente.',
                confirmButtonText: 'Aceptar'
            });
            window.location = "/product"
        } catch (error) {
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: error.response?.data?.message || 'Ocurrió un problema al iniciar sesión. Intenta nuevamente.',
                confirmButtonText: 'Aceptar'
            });
        }
    };

    const register = async (name, lastName, email, password) => {

        try {

            const response = await axios.post(registerEndpoint, { name, lastName, email, password });

            console.log("Register Response", response.data)

            Swal.fire({
                icon: 'success',
                title: '¡Registro exitoso!',
                text: 'Tu cuenta ha sido creada exitosamente.',
                confirmButtonText: 'Aceptar'
            });
        } catch (error) {
            Swal.fire({
                icon: 'error',
                title: 'Error en el registro',
                text: error.response?.data?.message || 'No se pudo completar el registro. Intenta nuevamente.',
                confirmButtonText: 'Aceptar'
            });
        }
    };

    const handleSubmitLogin = (e) => {
        e.preventDefault();
        // Llamar a la función login al enviar el formulario
        login(email, password);
    };

    const handleSubmitRegister = (e) => {
        e.preventDefault();

        register(name, lastName, email, password);
    }


    return (
        <div className="flex flex-col items-center mt-10">


            <div className="mb-4">
                <button
                    onClick={() => setIsLogin(true)}
                    className={`py-2 px-4 mr-2 ${isLogin ? 'bg-indigo-500 text-white' : 'bg-gray-300'}`}
                >
                    Iniciar Sesión
                </button>
                <button
                    onClick={() => setIsLogin(false)}
                    className={`py-2 px-4 ${!isLogin ? 'bg-indigo-500 text-white' : 'bg-gray-300'}`}
                >
                    Registrarse
                </button>
            </div>
            
            {isLogin && (
            <form onSubmit={handleSubmitLogin} className="max-w-md mx-auto bg-white p-8 shadow-md rounded-lg">
                <h2 className="text-2xl font-bold mb-6 text-gray-800">Iniciar Sesión</h2>

                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Correo Electrónico</label>
                    <input value={email} type="email" className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500" placeholder="tu@email.com" onChange={(e) => setEmail(e.target.value)} required />
                </div>

                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Contraseña</label>
                    <input value={password} type="password" className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500" placeholder="••••••••" onChange={(e) => setPassword(e.target.value)} required />
                </div>

                <div className="mb-4 flex items-center">
                    <input type="checkbox" id="remember" name="remember" className="mr-2" />
                    <label className="text-gray-700">Recuérdame</label>
                </div>

                <div className="mb-4 text-right">
                    <a href="#" className="text-indigo-500 hover:underline">¿Olvidaste tu contraseña?</a>
                </div>

                <div>
                    <button type="submit" className="w-full bg-indigo-500 text-white font-bold py-3 px-4 rounded-lg hover:bg-indigo-600 focus:outline-none focus:ring-4 focus:ring-indigo-300 transition duration-300">
                        Iniciar Sesión
                    </button>
                </div>
            </form>)}


            {!isLogin && (
            <form onSubmit={handleSubmitRegister} className="max-w-md mx-auto bg-white p-8 shadow-md rounded-lg">
                <h2 className="text-2xl font-bold mb-6 text-gray-800">Registrarse</h2>

                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Nombre</label>
                    <input
                        value={name}
                        type="text"
                        className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                        placeholder="Tu nombre"
                        onChange={(e) => setName(e.target.value)}
                        required
                    />
                </div>

                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Apellido</label>
                    <input
                        value={lastName}
                        type="text"
                        className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                        placeholder="Tu apellido"
                        onChange={(e) => setLastName(e.target.value)}
                        required
                    />
                </div>

                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Correo Electrónico</label>
                    <input
                        value={email}
                        type="email"
                        className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                        placeholder="tu@email.com"
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>

                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Contraseña</label>
                    <input
                        value={password}
                        type="password"
                        className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                        placeholder="••••••••"
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>

                <div className="mb-4 flex items-center">
                    <input type="checkbox" id="terms" name="terms" className="mr-2" required />
                    <label className="text-gray-700">
                        Acepto los <a href="#" className="text-indigo-500 hover:underline">términos y condiciones</a>
                    </label>
                </div>

                <div>
                    <button
                        type="submit"
                        className="w-full bg-indigo-500 text-white font-bold py-3 px-4 rounded-lg hover:bg-indigo-600 focus:outline-none focus:ring-4 focus:ring-indigo-300 transition duration-300"
                    >
                        Registrarse
                    </button>
                </div>
            </form>
            )}

        </div>
    )
}
export default Auth;