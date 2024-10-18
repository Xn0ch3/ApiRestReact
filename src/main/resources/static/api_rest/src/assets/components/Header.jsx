import { Link } from "react-router-dom";

const Header = () => {

    return (
        <header className="flex justify-between content-center bg-green-700 p-3">
            <div>
                <h1 className="text-2xl">Api Rest</h1>
            </div>
            <nav className="flex justify-center gap-6 text-xl">
                <Link to="/product">ListaProductos</Link>
                <Link to="/create">Crear Producto</Link>
                <Link to="/profile">Perfil</Link>
                <Link to="/logout">Cerrar Sesion</Link>
            </nav>
        </header>
    )
}
export default Header;