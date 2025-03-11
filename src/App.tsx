import Alert from "./components/Alert";
import ListGroup from "./components/ListGroup";
import Button from "./components/Button";
import { ReactNode, useEffect, useState } from "react";
import api from "./api/posts";
import SongList from "./components/SongList";
import SearchInput from "./components/SearchInput";
import CarouselFlow from "./components/CarouselFlow";

function App() {
  const [songs, setSongs] = useState([]);
  const [alertVisible, showAlert] = useState(false);

  const [data, setData] = useState<{ imageData: string[] }>({ imageData: [] });

  const setImageData = (data: string[]) => {
    setData({ imageData: data });
  };

  let items = ["Apples", "Oranges", "Bananas", "Pears", "Mangos"];
  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const response = await api.get("/song");
        setSongs(response.data);
      } catch (err) {}
    };
    fetchPosts();
  }, []);

  const handleSelectItem = (item: string) => {
    console.log(item);
  };
  return (
    <div>
      {alertVisible && (
        <Alert onClose={() => showAlert(false)}>YIPPEEEEEE</Alert>
      )}
      <Button color="dark" onClick={() => showAlert(true)}>
        Press Me!
      </Button>
      <Button color="danger" onClick={() => showAlert(true)}>
        UH OHHHHHHHH!
      </Button>
      <ListGroup
        items={items}
        heading="Fruits"
        onSelectItem={handleSelectItem}
      ></ListGroup>
      <SongList songs={songs}></SongList>
      <SearchInput setImageData={setImageData} />
      <CarouselFlow imageData={data.imageData}></CarouselFlow>
    </div>
  );
}

export default App;
