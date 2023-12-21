Many LLM applications require user-specific data that is not part of the model's training set. The primary way of accomplishing this is through Retrieval Augmented Generation (RAG). In this process, external data is _retrieved_ and then passed to the LLM when doing the _generation_ step.

LangChain provides all the building blocks for RAG applications - from simple to complex. This section of the documentation covers everything related to the _retrieval_ step - e.g. the fetching of the data. Although this sounds simple, it can be subtly complex. This encompasses several key modules.

![[Pasted image 20231208103413.png]]

### Document Loader

**Document loaders** load documents from many different sources. LangChain provides over 100 different document loaders as well as integrations with other major providers in the space, like AirByte and Unstructured. LangChain provides integrations to load all types of documents (HTML, PDF, code) from all types of locations (private S3 buckets, public websites).

Use document loaders to load data from a source as `Document`'s. A `Document` is a piece of text and associated metadata. For example, there are document loaders for loading a simple `.txt` file, for loading the text contents of any web page, or even for loading a transcript of a YouTube video.

Document loaders provide a "load" method for loading data as documents from a configured source. They optionally implement a "lazy load" as well for lazily loading data into memory.

```python
from langchain.document_loaders import TextLoader  
  
loader = TextLoader("./index.md")  
document = loader.load()
print(document)

[  
Document(page_content='---\nsidebar_position: 0\n---\n# Document loaders\n\nUse document loaders to load data from a source as `Document`\'s. A `Document` is a piece of text\nand associated metadata. For example, there are document loaders for loading a simple `.txt` file, for loading the text\ncontents of any web page, or even for loading a transcript of a YouTube video.\n\nEvery document loader exposes two methods:\n1. "Load": load documents from the configured source\n2. "Load and split": load documents from the configured source and split them using the passed in text splitter\n\nThey optionally implement:\n\n3. "Lazy load": load documents into memory lazily\n', metadata={'source': '../docs/docs/modules/data_connection/document_loaders/index.md'})  
]
```

### Document Transformers

A key part of retrieval is fetching only the relevant parts of documents. This involves several transformation steps to prepare the documents for retrieval. One of the primary ones here is splitting (or chunking) a large document into smaller chunks. LangChain provides several transformation algorithms for doing this, as well as logic optimized for specific document types (code, markdown, etc).

Once you've loaded documents, you'll often want to transform them to better suit your application. The simplest example is you may want to split a long document into smaller chunks that can fit into your model's context window. LangChain has a number of built-in document transformers that make it easy to split, combine, filter, and otherwise manipulate documents.

#### Text Splitters

