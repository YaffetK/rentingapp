import Navbar from "./components/Navbar";
import Image from "next/image";
import data from '../data.json'
import LoginForm from "./components/LoginForm";
import camera from '../public/camera.png'


const Home = () => {
  return (
    <main className="min-h-screen flex-grow ">
      <Navbar />

      <div className="flex w-full flex-col items-center mt-12 flex-grow min-h-fit  ">


        <Image
          className=""
          alt={data.name}
          src={camera}
          width={200}
          height={200}
        />
        <h1 className="font-semibold px-4 pt-2">{data.name}</h1>
        <p>{data.description}</p>

      </div>

      <LoginForm />



    </main>
  );
}

export default Home
