# Bài tập kiểm định và đánh giá chất lượng phần mềm

Chương trình Java tính điểm thưởng của khách hàng:

- Mỗi lần mua được cộng 10 điểm.
- Thành viên Premium được cộng thêm 5 điểm.
- Khách thường được cộng thêm 1 điểm.
- Số lần mua được giới hạn từ 0 đến 2 để tập hợp đường đi của phương thức là hữu hạn.

Phương thức `calculate` có cả vòng lặp `for` và lệnh rẽ nhánh `if...else`.

## Chạy chương trình

```bash
java src/main/java/vn/edu/phenikaa/Main.java
```

## Chạy kiểm thử và tạo báo cáo JaCoCo

```bash
mvn clean test
```

Báo cáo độ bao phủ nằm tại `target/site/jacoco/index.html`.

## Các đường đi khả thi của `calculate`

Do `purchases` chỉ nhận giá trị hợp lệ từ 0 đến 2, phương thức có 8 đường đi khả thi:

| Đường đi | `purchases` đại diện | `premiumMember` | Kết quả |
|---|---:|:---:|---|
| P1 | -1 | bất kỳ | Ném ngoại lệ do nhỏ hơn 0 |
| P2 | 3 | bất kỳ | Ném ngoại lệ do lớn hơn 2 |
| P3 | 0 | `true` | Vòng lặp 0 lần, trả về 5 |
| P4 | 0 | `false` | Vòng lặp 0 lần, trả về 1 |
| P5 | 1 | `true` | Vòng lặp 1 lần, trả về 15 |
| P6 | 1 | `false` | Vòng lặp 1 lần, trả về 11 |
| P7 | 2 | `true` | Vòng lặp 2 lần, trả về 25 |
| P8 | 2 | `false` | Vòng lặp 2 lần, trả về 21 |

`StatementCoverageTest` giải quyết yêu cầu bao phủ câu lệnh. `PathCoverageTest` kiểm tra đủ 8 đường đi nêu trên.
