import { islands } from "./importIsland.js";
islands.forEach(island => {
  const islandDiv = document.createElement("span");
  islandDiv.classList.add("island");

  const nameElement = document.createElement("h3");
  nameElement.textContent = island.name;
  islandDiv.appendChild(nameElement);

  if (island.country) {
    const countryElement = document.createElement("p");
    countryElement.textContent = island.country;
    islandDiv.appendChild(countryElement);
  }

  if (island.imageUrl) {
    const imageElement = document.createElement("img");
    imageElement.src = island.imageUrl;
    islandDiv.appendChild(imageElement);
  }

  islandContainer.appendChild(islandDiv);
});
