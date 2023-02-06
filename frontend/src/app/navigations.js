export const navigations = [
  { label: "현재시대", type: "label" },
  {
    name: "전체자산",
    icon: "trending_up",
    path: "/asset",
    iconText: "E",
  },
  {
    name: "주식",
    icon: "trending_up",
    children: [
      {
        name: "국내주식 재산현황",
        path: "/stock/domestic",
        iconText: "E",
      },
      {
        name: "해외주식 재산현황",
        path: "/stock/overseas",
        iconText: "E",
      },
    ],
  },
  {
    name: "제강",
    icon: "trending_up",
    children: [
      {
        name: "제강 예비처리",
        path: "/steel-making/pre-treatment",
        iconText: "E",
      },
      {
        name: "제강 1차정련",
        path: "/steel-making/1st-refining",
        iconText: "E",
      },
      {
        name: "제강 2차정련",
        path: "/steel-making/2nd-refining",
        iconText: "E",
      },
      { name: "제강 수강래들", path: "/steel-making/dsm-ladle", iconText: "E" },
      { name: "제강 내화물", path: "/steel-making/refractory", iconText: "E" },
      {
        name: "제강 작업지시",
        path: "/steel-making/instruction",
        iconText: "E",
      },
      {
        name: "제강 실적등록",
        path: "/steel-making/performance",
        iconText: "E",
      },
    ],
  },
  {
    name: "연주",
    icon: "trending_up",
    children: [
      {
        name: "연주 작업지시",
        path: "/continuous-casting/instruction",
        iconText: "E",
      },
      {
        name: "연주 실적등록",
        path: "/continuous-casting/performance",
        iconText: "E",
      },
    ],
  },
  {
    name: "압연",
    icon: "trending_up",
    children: [
      { name: "압연 작업지시", path: "/rolling/instruction", iconText: "E" },
      { name: "압연 실적등록", path: "/rolling/performance", iconText: "E" },
    ],
  },
  {
    name: "출하",
    icon: "trending_up",
    children: [
      { name: "출하 작업지시", path: "/shipment/instruction", iconText: "E" },
      { name: "출하 실적등록", path: "/shipment/performance", iconText: "E" },
    ],
  },
  {
    name: "철강생산 완료",
    icon: "trending_up",
    children: [
      { name: "철강 목록", path: "/production/completion", iconText: "E" },
    ],
  },
];
