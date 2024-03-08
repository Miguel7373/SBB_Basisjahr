
export default class Island {

  constructor({ name, country = null, imageUrl = null }) {
    this.name = name;
    this.country = country;
    this.imageUrl = imageUrl;
  }
}
