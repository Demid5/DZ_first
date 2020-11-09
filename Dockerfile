FROM demid5/ubserver
COPY task7_1.py /
EXPOSE 80
CMD ["python3", "task7_1.py", "&"]
