
export default class Island {
  name;
  country = null;
  imageUrl = null;

  constructor({ name, country = null, imageUrl = null }) {
    this.name = name;
    this.country = country;
    this.imageUrl = imageUrl;
  }
}
