@db
Feature: Question-2 API

  Scenario Outline: Verify the second question answer with DB
    Given "<staff_id>","<month>" and "<total_sales>"

    Examples:
      | staff_id | month    | total_sales |
      | 1        | April    | 14080.36    |
      | 1        | February | 4160.84     |
      | 1        | March    | 11776.83    |
      | 1        | May      | 234.09      |
      | 2        | April    | 14479.10    |
      | 2        | February | 4191.00     |
      | 2        | March    | 12109.73    |
      | 2        | May      | 280.09      |
