import { ReactNode } from "react";

function SongList({ songs }) {
  return (
    <>
      <h1> Songs</h1>
      {songs.map((song) => (
        <div className="box"> {song.name}</div>
      ))}
    </>
  );
}

export default SongList;
