import Navbar from "./components/Navbar";
import Image from "next/image";
import data from '../data.json'
import LoginForm from "./components/LoginForm";


const Home = () => {
  return (
    <main className="min-h-screen">
      <Navbar />

      <div className="flex w-full flex-col items-center mt-12 flex-grow min-h-fit  ">

        <Image
          className="rounded-full"
          alt={data.name}
          src={data.avatar}
          width={120}
          height={120}
        />
        <h1 className="font-semibold px-4 pt-2">{data.name}</h1>

      </div>

      <LoginForm />


    </main>
  );
}

export default Home
