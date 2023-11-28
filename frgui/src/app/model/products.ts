export class Products {
  productName: string;
  productDescription: string;
  price: number;
  category: string;
  stockQuantity: number;

  constructor(
    productName: string,
    productDescription: string,
    price: number,
    category: string,
    stockQuantity: number
  ) {
    this.productName = productName;
    this.productDescription = productDescription;
    this.price = price;
    this.category = category;
    this.stockQuantity = stockQuantity;
  }
}
