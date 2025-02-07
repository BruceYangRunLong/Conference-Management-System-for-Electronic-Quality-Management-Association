## 目录结构

```
├── pages
│   ├── cooperate
│   │   ├── cooperate.js
│   │   ├── cooperate.json
│   │   ├── cooperate.wxml
│   │   └── cooperate.wxss
│   ├── meetDetail
│   │   ├── meetDetail.js
│   │   ├── meetDetail.json
│   │   ├── meetDetail.wxml
│   │   └── meetDetail.wxss
│   ├── meetReceipt
│   │   ├── meetReceipt.js
│   │   ├── meetReceipt.json
│   │   ├── meetReceipt.wxml
│   │   └── meetReceipt.wxss
```

## 主要文件和页面

### 合作信息页面

#### cooperate

- **功能：**
  - 展示合作信息页面。
  - 显示合作伙伴、合作项目以及相关详情。
  - 提供合作申请和咨询功能。
  - 包含合作案例展示。
- **文件说明：**
  - **cooperate.js**：处理合作信息页面的逻辑，包括从服务器获取合作列表，并提供导航到详细页面的功能。
  - **cooperate.json**：页面的配置文件，定义页面的导航栏标题和启用的组件。
  - **cooperate.wxml**：定义页面的结构，包括展示合作信息的列表。
  - **cooperate.wxss**：定义页面的样式，包括合作信息列表的样式。

### 会议详情页面

#### meetDetail

- **功能：**
  - 展示会议的详细信息页面。
  - 显示会议主题、时间、地点、主办方等信息。
  - 提供会议报名功能。
  - 包含会议议程和参会者列表。
- **文件说明：**
  - **meetDetail.js**：会议详情页面的逻辑处理，包括获取会议详细信息和处理用户操作。
  - **meetDetail.json**：页面的配置文件，定义页面的导航栏标题和启用的组件。
  - **meetDetail.wxml**：定义页面的结构，包括会议信息展示和用户交互部分。
  - **meetDetail.wxss**：定义页面的样式，使会议详情页面美观且易于使用。

### 会议回执页面

#### meetReceipt

- **功能：**
  - 展示会议回执页面。
  - 用户在参加会议后填写并提交回执。
  - 包含会议反馈和满意度调查。
- **文件说明：**
  - **meetReceipt.js**：会议回执页面的逻辑处理，包括提交回执信息和处理用户交互。
  - **meetReceipt.json**：页面的配置文件，定义页面的导航栏标题和启用的组件。
  - **meetReceipt.wxml**：定义页面的结构，包括回执表单和反馈部分。
  - **meetReceipt.wxss**：定义页面的样式，使会议回执页面美观且易于填写。