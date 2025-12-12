const API = "http://localhost:8080/api/songs";
const audio = document.getElementById("audio");
const list = document.getElementById("song-list");

async function loadSongs() {
    const response = await fetch(API);
    const songs = await response.json();

    songs.forEach(song => {
        const li = document.createElement("li");
        li.textContent = `${song.title} — ${song.artist}`;
        
        li.onclick = () => {
            audio.src = `${API}/stream/${song.id}`;
            audio.play();
        };

        list.appendChild(li);
    });
}

loadSongs();
