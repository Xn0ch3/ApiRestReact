import Auth from "./Auth"

const Home = () => {

    return (
        <div className="min-h-screen flex flex-col">
            <header className="bg-green-700 p-3">
                <h1 className="text-2xl">Api Rest</h1>
            </header>

            <main className="flex-1 w-full overflow-auto">

            <Auth></Auth>

            </main>

            <footer className="h-16 w-full flex items-center justify-center">

            </footer>
        </div>
    )
}
export default Home