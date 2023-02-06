export const numberLogic = (data) => {
  const newData = data;
  data.forEach((element) => {
    element.price = element.price
      .toString()
      .replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    element.totalPrice = element.totalPrice
      .toString()
      .replace(/\B(?=(\d{3})+(?!\d))/g, ",");
  });
  return newData;
};
