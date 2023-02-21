export const tableHeaderFlex = (headerColumns) => {
  headerColumns.forEach((element) => (element.flex = 1));
};

export const numberFormat = (number) => {
  const formatedNumber = number
    .toString()
    .replace(/\B(?=(\d{3})+(?!\d))/g, ",");
  return formatedNumber;
};
